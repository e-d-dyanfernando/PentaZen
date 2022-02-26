import React from 'react'
import '../../components/learningCard/LearningCard.scss'
import LearningCard from '../../components/learningCard/LearningCard.js'
import {Link,Route,Switch} from 'react-router-dom'
import Greeting from '../../components/greetings/Greeting.js'


const Learning = () => {
    return (
        <div className="screens">
            <section className="hero-section">
            <div className="card-grid">


            
              <LearningCard  direct="/greetings" title="GREETINGS"> </LearningCard >
              <LearningCard direct="/foods"  title="FOODS"></LearningCard > 
              <LearningCard direct="/family"  title="FAMILY"></LearningCard > 
              <LearningCard direct="/animals"  title="ANIMALS"></LearningCard > 
       
    

            </div>
            </section>
        </div>
    )
}

export default Learning