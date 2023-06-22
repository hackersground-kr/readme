import React from "react";

import { Route, Routes } from "react-router-dom";
import { Login } from "../components/Auth/Login";
import { Signup } from "../components/Auth/Signup";
import { HomePage } from "../pages/Home";
import { UserRecommendPage } from "../pages/UserRecommend";
import { List } from "../pages/List";

export const Router = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/list" element={<List />} />
        <Route path="/recommend" element={<UserRecommendPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
};
