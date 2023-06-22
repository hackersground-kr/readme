import React from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";
import { useLogin } from "../../../hooks/useLogin";

export const Login = () => {
  const navigate = useNavigate();
  const { onLoginChange, email, password, onLoginSubmit } = useLogin();
  return (
    <div>
      <div>
        <S.Form onSubmit={onLoginSubmit}>
          <S.FormTitle>
            서로를 이끌다
            <br />
            ReadMe
          </S.FormTitle>
          <S.FormInput type="email" placeholder="email" name="email" value={email} onChange={onLoginChange}/>
          <S.FormInput2 type="password" placeholder="password" name="password" value={password} onChange={onLoginChange}/>
          <S.FormButton type="submit">로그인</S.FormButton>
          <S.LoginHref>
            아직 회원이 아니신가요?{" "}
            <S.LoginHref2 onClick={() => navigate("/signup")}>회원가입</S.LoginHref2>
          </S.LoginHref>
        </S.Form>
      </div>
    </div>
  );
};
