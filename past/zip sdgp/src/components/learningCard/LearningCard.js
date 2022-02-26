import React from 'react'
import './LearningCard.scss'
import {Link,Route,Switch} from 'react-router-dom'

function LearningCard(props) {
 

    
    return (
    <div>
        <Link className="card" to={props.direct}>
            <div className="card__background">
                <img src={props.mainImg}/>
               
            </div>
            <div className="card__content">
                <h3 className="card__heading">{props.title}</h3>
       
                
            </div>
      </Link>
      </div>  
    )
}

export default LearningCard