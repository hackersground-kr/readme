import React from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

import { ToastError } from "../lib/Toast";

const NotFound = () => {
  const navigate = useNavigate();
  useEffect(() => {
    ToastError("존재하지않는 페이지입니다.");
    navigate("/");
  }, [navigate]);
  return <></>;
};

export default NotFound;
