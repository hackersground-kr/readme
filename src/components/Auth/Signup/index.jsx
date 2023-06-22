import React, { useState } from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";
import { useSignup } from "../../../hooks/useSignup";

export const Signup = () => {
  const [selectedOption, setSelectedOption] = useState(null);
  const { onSignUpChange, email, password, onSignUpSubmit } = useSignup();
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
            placeholder="학교 이름"
            name="school"
            onChange={onSignUpChange}
          />
        )}

        {selectedOption === "학교" && (
          <S.FormTypeInputNumber
            type="number"
            placeholder="학생 수"
            name="student"
            onChange={onSignUpChange}
          />
        )}

        {selectedOption === "학교" && (
          <label>
            <S.FormRadioType
              type="radio"
              name="type"
              value="고등학교"
              id="H"
              // checked={selectedType === "고등학교"}
              onChange={onSignUpChange}
            />
            <S.RadioTextType>고등학교</S.RadioTextType>
            <S.FormRadioType2
              type="radio"
              name="type"
              value="대학교"
              id="u"
              // checked={selectedType === "대학교"}
              onChange={onSignUpChange}
            />
            <S.RadioTextType2>대학교</S.RadioTextType2>
            <S.FormRadioType3
              type="radio"
              name="type"
              value="대학원"
              id="U"
              // checked={selectedType === "대학원"}
              onChange={onSignUpChange}
            />
            <S.RadioTextType3>대학원</S.RadioTextType3>
            <S.FormRadioType4
              type="radio"
              name="type"
              value="기타"
              id="N"
              // checked={selectedType === "기타"}
              onChange={onSignUpChange}
            />
            <S.RadioTextType4>기타</S.RadioTextType4>
          </label>
        )}

        <S.FormTypeInput2 type="text" placeholder="주소" name="adress" onChange={onSignUpChange} />

        {selectedOption === "기업" && (
          <S.FormTypeInput
            type="text"
            placeholder="기업 이름"
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
