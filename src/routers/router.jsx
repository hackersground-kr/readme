import React from "react";

import { Route, Routes } from "react-router-dom";
import { Login } from "../components/Auth/Login";
import { Signup } from "../components/Auth/Signup";
import { HomePage } from "../pages/Home";
import { UserApplyPage } from "../pages/UserApply";
import { UserRecommendPage } from "../pages/UserRecommend";

export const Router = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/accept" element={<UserApplyPage />} />
        <Route path="/recommend" element={<UserRecommendPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </div>
  );
};
