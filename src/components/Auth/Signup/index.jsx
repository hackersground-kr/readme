import React, { useState } from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";

export const Signup = () => {
  const [selectedOption, setSelectedOption] = useState(null); // 기업 또는 학교 옵션을 저장하기 위한 상태값
  const navigate = useNavigate();

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <S.GlobalStyle />
      <S.Form>
        <S.FormTitle>
          서로를 이끌다
          <br />
          ReadMe
        </S.FormTitle>
        <S.FormInput type="email" placeholder="email" />
        <S.FormInput2 type="password" placeholder="password" />

        <label>
          <S.FormRadio
            type="radio"
            name="radio"
            value="학교"
            checked={selectedOption === "학교"}
            onChange={handleOptionChange}
          />
          <S.RadioText>학교</S.RadioText>
        </label>

        <label>
          <S.FormRadio2
            type="radio"
            name="radio"
            value="기업"
            checked={selectedOption === "기업"}
            onChange={handleOptionChange}
          />
          <S.RadioText2>기업</S.RadioText2>
        </label>

        {selectedOption === "학교" && <S.FormTypeInput type="text" placeholder="학교 생성" />}

        {selectedOption === "기업" && <S.FormTypeInput type="text" placeholder="기업 생성" />}

        <S.FormButton>회원가입</S.FormButton>
        <S.LoginHref>
          혹시 회원이신가요? <S.LoginHref2 onClick={() => navigate("/login")}>로그인</S.LoginHref2>
        </S.LoginHref>
      </S.Form>
    </div>
  );
};
