import React from "react";
import "./food.scss";
import apple from "./food/apple.PNG";
import banana from "./food/banana.PNG";
import bean from "./food/bean.PNG";
import bread from "./food/bread.PNG";
import breakfast from "./food/breakfast.PNG";
import bun from "./food/bun.PNG";
import cake from "./food/cake.PNG";
import chicken from "./food/chicken.PNG";
import coconut from "./food/coconut.PNG";
import cook from "./food/cook.PNG";
import cup from "./food/cup.PNG";
import curd from "./food/curd.PNG";
import fish from "./food/fish.PNG";
import food from "./food/food.PNG";
import fruit from "./food/fruit.PNG";
import hoppers from "./food/hoppers.PNG";
import sentence1 from "./food/sentence1.PNG";
import sentence2 from "./food/sentence2.PNG";
import GalleryImage from "./../galleryImage/galleryimage.js";
import GallerySentence from "./../GallerySentence/gallerysentence.js";

const animal = () => {
  return (
    <div classNameName="screens">
      <h1 className="head">Signs For Animals</h1>
      <div className="main-back">
        <div className="container">
          <div className="row">
            <div className="flexRow">
              <div>
                <GalleryImage className="photo" image={apple} />
                <GalleryImage className="photo" image={banana} />
                <GalleryImage className="photo" image={bean} />
                <GalleryImage className="photo" image={bread} />
              </div>
              <div>
                <GalleryImage className="photo" image={breakfast} />
                <GalleryImage className="photo" image={bun} />
                <GalleryImage className="photo" image={cake} />
                <GalleryImage className="photo" image={chicken} />
              </div>
              <div>
                <GalleryImage className="photo" image={coconut} />
                <GalleryImage className="photo" image={cook} />
                <GalleryImage className="photo" image={cup} />
                <GalleryImage className="photo" image={curd} />
              </div>
              <div>
                <GalleryImage className="photo" image={fish} />
                <GalleryImage className="photo" image={food} />
                <GalleryImage className="photo" image={fruit} />
                <GalleryImage className="photo" image={hoppers} />
              </div>
            </div>
          </div>
        </div>
      </div>

      <h2>Sentences</h2>
      <div className="flexColumn">
        <GallerySentence image={sentence1} />
        <GallerySentence image={sentence2} />
      </div>
    </div>
  );
};

export default animal;
