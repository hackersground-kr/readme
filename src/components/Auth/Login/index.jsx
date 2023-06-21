import React from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";

export const Login = () => {
  const navigate = useNavigate();
  return (
    <div>
      <div>
        <S.Form>
          <S.FormTitle>
            서로를 이끌다
            <br />
            ReadMe
          </S.FormTitle>
          <S.FormInput type="email" />
          <S.FormInput2 type="password" />
          <S.FormButton>로그인</S.FormButton>
          <S.LoginHref>
            아직 회원이 아니신가요?{" "}
            <S.LoginHref2 onClick={() => navigate("/signup")}>회원가입</S.LoginHref2>
          </S.LoginHref>
        </S.Form>
      </div>
    </div>
  );
};
