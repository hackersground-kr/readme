import React from "react";

import { Route, Routes } from "react-router-dom";
import { Login } from "../components/Auth/Login";

export const Router = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Login />} />
      </Routes>
    </div>
  );
};
