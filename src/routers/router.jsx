import React from "react";

import { Route, Routes } from "react-router-dom";
import { Login } from "../components/Auth/Login";
import { Signup } from "../components/Auth/Signup";

export const Router = () => {
  return (
    <div>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
};
