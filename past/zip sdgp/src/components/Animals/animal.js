import React from "react";
import "./animal.scss";
import Animal from "./Animals/animal.PNG";
import cat from "./Animals/cat.PNG";
import cock from "./Animals/cock.PNG";
import cow from "./Animals/Cow.PNG";
import dog from "./Animals/dog.PNG";
import Elephant from "./Animals/Elephant.PNG";
import Fish from "./Animals/Fish.PNG";
import Flower from "./Animals/Flower.PNG";
import Goat from "./Animals/Goat.PNG";
import lion from "./Animals/Lion.PNG";
import monkey from "./Animals/monkey.PNG";
import ocean from "./Animals/Ocean.PNG";
import Pig from "./Animals/Pig.PNG";
import rat from "./Animals/Rat.PNG";
import snake from "./Animals/Snake.PNG";
import turtle from "./Animals/Turtle.PNG";
import sentence1 from "./Animals/sentence1.PNG";
import sentence2 from "./Animals/sentence2.PNG";
import sentence3 from "./Animals/sentence3.PNG";
import sentence4 from "./Animals/sentence4.PNG";

import GalleryImage from "./../galleryImage/galleryimage.js";
import GallerySentence from "./../GallerySentence/gallerysentence.js";

const animal = () => {
  return (
    <div classNameName="screens">
      <h1>Signs For Animals</h1>
      <h1 className="head">Signs For Animals</h1>
      <div className="main-back">
        <div className="container">
          <div className="row">
            <div className="flexRow">
              <div>
                <GalleryImage className="photo" image={Animal} />
                <GalleryImage className="photo" image={cat} />
                <GalleryImage className="photo" image={cock} />
                <GalleryImage className="photo" image={cow} />
              </div>
              <div>
                <GalleryImage className="photo" image={dog} />
                <GalleryImage className="photo" image={Elephant} />
                <GalleryImage className="photo" image={Fish} />
                <GalleryImage className="photo" image={Flower} />
              </div>
              <div>
                <GalleryImage className="photo" image={Goat} />
                <GalleryImage className="photo" image={lion} />
                <GalleryImage className="photo" image={monkey} />
                <GalleryImage className="photo" image={ocean} />
              </div>
              <div>
                <GalleryImage className="photo" image={Pig} />
                <GalleryImage className="photo" image={rat} />
                <GalleryImage className="photo" image={snake} />
                <GalleryImage className="photo" image={turtle} />
              </div>
            </div>
          </div>
        </div>
      </div>

      <h2>Sentences</h2>
      <div className="flexColumn">
        <GallerySentence image={sentence1} />
        <GallerySentence image={sentence2} />
        <GallerySentence image={sentence3} />
        <GallerySentence image={sentence4} />
      </div>
    </div>
  );
};

export default animal;
