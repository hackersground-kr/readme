import React from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";

export const Signup = () => {
  const navigate = useNavigate();
  return (
    <div>
      <S.Form>
        <S.FormTitle>
          서로를 이끌다
          <br />
          ReadMe
        </S.FormTitle>
        <S.FormInput type="email" />
        <S.FormInput2 type="password" />
        <S.FormRadio type="radio" name="radio" value="학교" />
        <S.RadioText>학교</S.RadioText>
        <S.FormRadio2 type="radio" name="radio" value="기업" />
        <S.RadioText2>기업</S.RadioText2>
        <S.FormButton>회원가입</S.FormButton>
        <S.LoginHref>
          혹시 회원이신가요??{" "}
          <S.LoginHref2 onClick={() => navigate("/login")}>로그인</S.LoginHref2>
        </S.LoginHref>
      </S.Form>
    </div>
  );
};
