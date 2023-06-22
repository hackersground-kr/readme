import React from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

import Toast from "../lib/Toast";

const NotFound = () => {
  const navigate = useNavigate();
  useEffect(() => {
    Toast.fire({
      icon: "error",
      title: "존재하지 않는 페이지입니다",
    });
    navigate("/");
  }, [navigate]);
  return <></>;
};

export default NotFound;
