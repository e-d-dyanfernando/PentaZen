import React from "react";
import "./galleryimage.scss";

const galleryimage = (props) => {
  return (
    <div className="col-3">
      <a href="#">
        <img src={props.image} className="img-responsive" alt="name" />
      </a>
    </div>
  );
};

export default galleryimage;
