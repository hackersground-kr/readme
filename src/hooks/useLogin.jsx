import axios from "axios";
import { useCallback, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastError, ToastSuccess, ToastWarning } from "../lib/Toast";

export const useLogin = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const URL = `https://readme-api-manager.azure-api.net/user/login`;

  const onLoginChange = useCallback((e) => {
    if (e.target.name === "email") {
      setEmail(e.target.value);
    } else if (e.target.name === "password") {
      setPassword(e.target.value);
    }
  }, []);

  const onLoginSubmit = useCallback(
    async (e) => {
      e.preventDefault();

      if (email && password) {
        try {
          //   console.log(email, password, URL);
          const response = await axios.post(URL, {
            email: email,
            password: password,
          });

          console.log(response);
          const { accessToken, refreshToken } = response.data.data;
          localStorage.setItem("accessToken", accessToken);
          document.cookie = `refreshToken=${refreshToken}`;
          ToastSuccess("로그인에 성공하였습니다.");
          navigate("/login");
        } catch (error) {
          ToastError("로그인에 실패했습니다.\n관리자에게 문의해주세요");
        }
      } else {
        ToastWarning("모든 항목을 입력해주세요");
      }
    },
    [email, password, URL, navigate],
  );
  return { onLoginChange, email, password, onLoginSubmit };
};
