import React from "react";
import '../Pages_css/Pass.css';
import DropFileInput from "./DropFileInput.jsx"

function Pass() {
  return (
    <div className="Drag-and-drop">
      <DropFileInput></DropFileInput>
      <input type="text" className="Comment" placeholder="Оставь комментарий к изменениям" />
    </div>
  );
}

export default Pass;
