import React from "react";
import "./App.css";
import { BrowserRouter, HashRouter } from "react-router-dom";
import { Router } from "./routers/router";

function App() {
  return (
    <div className="App">
      <HashRouter>
        <Router />
      </HashRouter>
    </div>
  );
}

export default App;
