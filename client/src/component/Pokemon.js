import React from 'react'
import axios from 'axios'
const url = "https://floating-tor-71053.herokuapp.com/pokemon/";

class Pokemon extends React.Component {
        constructor(props){
        super(props)
        this.state = {}
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
      }
      async getPokemon(){
        try{
         const res = await axios.get(url)
         this.setState({pokedex :res.data}) 
         console.log(res.data) 
       } catch(e){
         console.error(e);
       }
     }
      async handleSubmit(e){
        e.preventDefault()
        const {name,type,level,found,ability} = this.state;
        const pokemons = {name,type,level,found,ability};
        try{    
                
                const res = await axios.post(url, pokemons);
                console.log(res.data)
                const updateRes = await axios.get(url);
                this.setState({ pokedex: updateRes.data });
                
                

        } catch(e) {
            console.error(e.message)
        }
      }

      async handleDelete(id) {
        console.log(url + id);
        try {
          const res = await axios.delete(url + id);
          console.log(res.data);
          const updateRes = await axios.get(url);
          this.setState({ pokedex: updateRes.data });
        } catch(e) {
          console.error(e.message);
        }
      }

      
      handleChange(e){
          this.setState({[e.target.name]: e.target.value})
      }

    
      componentDidMount(){
          this.getPokemon()
      }
    render() {
        return (
            <div>
              <div id="text"><h1>Create Your Pokemon</h1></div>
              
              <div id="pokemon-container">
               <form
               onChange={this.handleChange}
               onSubmit={this.handleSubmit}
               >
               <label>Name <input type="text" placeholder="name" name="name"/>
                </label>
               <label>Type <input type="text" placeholder="type" name="type"/>
                </label>
               <label>Level <input type="text" placeholder="level" name="level"/>
                </label>
               <label>Found <input type="text" placeholder="found" name="found"/>
                </label>
                <label>Ability <input type="text" placeholder="ability" name="ability"/>
                </label>
                <input id="submit" type="submit"/>
               </form>
               </div>
                <div id="list"> {this.state.pokedex &&  this.state.pokedex.map(poke=><li key={ poke.id }> Name:{poke.name} Type: {poke.type} Level:{poke.level} Ability: {poke.ability}<button onClick = {()=>this.handleDelete(poke.id)}>delete</button></li>)}</div>

            </div>
            
        )
    }
}

export default Pokemon
