import React from "react";

import { Route, Routes } from "react-router-dom";
import { Login } from "../components/Auth/Login";
import { Signup } from "../components/Auth/Signup";
import { Home } from "../pages/Home";

export const Router = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
};
