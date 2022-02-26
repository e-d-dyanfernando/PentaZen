import Header from './components/Header/Header'
import React, { Component } from 'react'
import { Route } from 'react-router-dom';

import SignUp from './screens/SignIN/SignIn';
import SignIn from './screens/SignUP/SignUp';
import Home from './screens/Home/LandviewSection';
import Learning from './screens/Learning/Learning';
import Community from './screens/Community/Community';
import VoiceToSign from './screens/Features/VoiceToSign/VoiceToSign';
import SignToWord from './screens/Features/SignToWord/SignToWord';
import WordToSign from './screens/Features/WordToSign/WordToSign';
import Greeting from './components/greetings/Greeting';
import Food from './components/Foods/food';
import animalGallery from './components/Animals/animal';
import Family from './components/Family/family';



class App extends Component {

  render() {
    return (
      <div>
        <Header />                   
        <Route path="/" exact={true} component={Home} />
        <Route path='/Sign In' component={SignIn} />  
        <Route path='/Sign Up' component={SignUp} />               
        <Route path='/Learning' component={Learning} /> 
        <Route path='/Community' component={Community} /> 
        <Route path='/Features/VoiceToSign' component={VoiceToSign}/>  
        <Route path='/Features/SignToWord' component={SignToWord}/>  
        <Route path='/Features/WordToSign' component={WordToSign}/>
        <Route path='/greetings' component={Greeting}/>     
        <Route path='/foods' component={Food}/>    
        <Route path='/family' component={Family}/>  
        <Route path='/animals' component={animalGallery}/>                  
      </div>
    );
  }

}

export default App;
