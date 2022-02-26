import React from "react";
import "./gallerysentence.scss";

const gallerysentence = (props) => {
  return (
    <div className="col-3s">
      <a href="#">
        <img src={props.image} className="img-responsive" alt="name" />
      </a>
    </div>
  );
};

export default gallerysentence;
