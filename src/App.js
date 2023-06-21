import React from "react";
import "./App.css";
import { BrowserRouter } from "react-router-dom";
import { Router } from "./routers/router";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Router />
      </BrowserRouter>
    </div>
  );
}

export default App;
