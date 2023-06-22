import React, { useState } from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";
import { useSignup } from "../../../hooks/useSignup";

export const Signup = () => {
  const [selectedOption, setSelectedOption] = useState(null);
  const { onSignUpChange, email, password, onSignUpSubmit } = useSignup(selectedOption);
  const navigate = useNavigate();

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <S.GlobalStyle />
      <S.Form onSubmit={onSignUpSubmit}>
        <S.FormTitle>
          서로를 이끌다
          <br />
          ReadMe
        </S.FormTitle>
        <S.FormInput
          type="email"
          placeholder="email"
          name="email"
          value={email}
          onChange={onSignUpChange}
        />
        <S.FormInput2
          type="password"
          placeholder="password"
          name="password"
          value={password}
          onChange={onSignUpChange}
        />

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

        {selectedOption === "학교" && (
          <S.FormTypeInput
            type="text"
            placeholder="학교 생성"
            name="school"
            onChange={onSignUpChange}
          />
        )}

        {selectedOption === "기업" && (
          <S.FormTypeInput
            type="text"
            placeholder="기업 생성"
            name="company"
            onChange={onSignUpChange}
          />
        )}

        <S.FormButton type="submit">회원가입</S.FormButton>
        <S.LoginHref>
          혹시 회원이신가요? <S.LoginHref2 onClick={() => navigate("/login")}>로그인</S.LoginHref2>
        </S.LoginHref>
      </S.Form>
    </div>
  );
};
