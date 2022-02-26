import React from "react";
import "./Greeting.scss";
import DntUnderstand from "./greetings/dont understand.PNG";
import GdAft from "./greetings/good afternoon.PNG";
import GdEvn from "./greetings/good evening.PNG";
import GdMor from "./greetings/good morning.PNG";
import GdNigh from "./greetings/good night.PNG";
import HwArYou from "./greetings/how are you.PNG";
import LvU from "./greetings/loveyou.PNG";
import NcToMtU from "./greetings/nice to meet you.PNG";
import Name from "./greetings/name.PNG";
import SignName from "./greetings/sign name.PNG";
import Sorry from "./greetings/sorry.PNG";
import TnkU from "./greetings/thank you.PNG";
import Understand from "./greetings/understand.PNG";
import Wc from "./greetings/welcome.PNG";

import sentence1 from "./greetings/sentence1.PNG";
import sentence2 from "./greetings/sentence2.PNG";
import GalleryImage from "./../galleryImage/galleryimage.js";
import GallerySentence from "./../GallerySentence/gallerysentence.js";

const Greeting = () => {
  return (
    <div classNameName="screens">
      <h1 className="head">Signs For Animals</h1>
      <div className="main-back">
        <div className="container">
          <div className="row">
            <div className="flexRow">
              <div>
                <GalleryImage className="photo" image={DntUnderstand} />
                <GalleryImage className="photo" image={GdAft} />
                <GalleryImage className="photo" image={GdEvn} />
                <GalleryImage className="photo" image={GdMor} />
              </div>
              <div>
                <GalleryImage className="photo" image={GdNigh} />
                <GalleryImage className="photo" image={HwArYou} />
                <GalleryImage className="photo" image={LvU} />
                <GalleryImage className="photo" image={NcToMtU} />
              </div>
              <div>
                <GalleryImage className="photo" image={Name} />
                <GalleryImage className="photo" image={SignName} />
                <GalleryImage className="photo" image={TnkU} />
                <GalleryImage className="photo" image={Sorry} />
              </div>
              <div>
                <GalleryImage className="photo" image={Understand} />
                <GalleryImage className="photo" image={Wc} />
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

export default Greeting;
