import React from "react";
import "./family.scss";
import baby from "./family/baby.PNG";
import daughter from "./family/daughter.PNG";
import ElBrother from "./family/elder brother.PNG";
import ElSister from "./family/elder sister.PNG";
import father from "./family/father.PNG";
import friend from "./family/friend.PNG";
import Gmom from "./family/grandmother.PNG";
import GFather from "./family/grandfather.PNG";
import HW from "./family/husband wife.PNG";
import Mboy from "./family/male boy.PNG";
import Ybro from "./family/Ybro.PNG";
import mother from "./family/mother.PNG";
import Ysis from "./family/Ysis.PNG";
import person from "./family/person.PNG";
import son from "./family/son.PNG";
import woman from "./family/woman.PNG";
import sentence1 from "./family/sentence1.PNG";
import sentence2 from "./family/sentence2.PNG";

import GalleryImage from "./../galleryImage/galleryimage.js";
import GallerySentence from "./../GallerySentence/gallerysentence.js";

const family = () => {
  return (
    <div classNameName="screens">
      <h1>Signs For family</h1>
      <h1 className="head">Signs For family</h1>
      <div className="main-back">
        <div className="container">
          <div className="row">
            <div className="flexRow">
              <div>
                <GalleryImage className="photo" image={baby} />
                <GalleryImage className="photo" image={daughter} />
                <GalleryImage className="photo" image={ElBrother} />
                <GalleryImage className="photo" image={ElSister} />
              </div>
              <div>
                <GalleryImage className="photo" image={father} />
                <GalleryImage className="photo" image={friend} />
                <GalleryImage className="photo" image={Gmom} />
                <GalleryImage className="photo" image={GFather} />
              </div>
              <div>
                <GalleryImage className="photo" image={HW} />
                <GalleryImage className="photo" image={Mboy} />
                <GalleryImage className="photo" image={Ybro} />
                <GalleryImage className="photo" image={mother} />
              </div>
              <div>
                <GalleryImage className="photo" image={Ysis} />
                <GalleryImage className="photo" image={woman} />
                <GalleryImage className="photo" image={person} />
                <GalleryImage className="photo" image={son} />
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

export default family;
