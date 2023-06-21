import styled, { createGlobalStyle } from "styled-components";

export const GlobalStyle = createGlobalStyle`
    body {
        background: #FAFAFA;
    }
`;


export const Form = styled.form`
  position: absolute;
  width: 600px;
  height: 880px;
  text-align: center;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  /* #FFFFFF */

  background: #ffffff;
  /* sidebar_sha */

  box-shadow: 1px 1px 20px rgba(183, 183, 183, 0.2);
  border-radius: 10px;
`;

export const FormTitle = styled.span`
  width: 100%;
  position: absolute;
  left: 0%;
  top: 9.96%;
  bottom: 82.71%;

  font-family: "Pretendard";
  font-style: normal;
  font-weight: 900;
  font-size: 24px;
  line-height: 29px;
  text-align: center;

  /* #316AE2 */

  color: #000000;
`;

export const FormInput = styled.input`
  position: absolute;
  width: 502px;
  height: 45px;
  left: 25px;
  top: 420px;
  margin-bottom: 20px;

  border: none;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  /* #F2F2F2 */

  background: #f2f2f2;
  border-radius: 10px;

  font-size: 25px;
  padding: 20px;
`;

export const FormInput2 = styled.input`
  position: absolute;
  width: 502px;
  height: 45px;
  left: 25px;
  top: 520px;
  margin-bottom: 20px;

  border: none;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  /* #F2F2F2 */

  background: #f2f2f2;
  border-radius: 10px;

  font-size: 25px;
  padding: 20px;
`;

export const FormButton = styled.button`
  position: absolute;
  width: 540px;
  height: 78px;
  left: 25px;
  top: 750px;

  border: none;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  background: #17bdff;
  border-radius: 10px;

  cursor: pointer;
`;

export const LoginHref = styled.span`
  /* 아직 회원이 아니신가요? 회원가입 */

  position: absolute;
  width: 240px;
  height: 24px;
  left: 180px;
  top: 848px;

  font-family: "Pretendard";
  font-style: normal;
  font-weight: 900;
  font-size: 18px;
  line-height: 135.5%;
  /* or 24px */

  text-align: center;

  /* #7A7A7A */

  color: #7a7a7a;
`;

export const LoginHref2 = styled.span`
  /* position: absolute; */
  width: 240px;
  height: 24px;
  left: 0;

  font-family: "Pretendard";
  font-style: normal;
  font-weight: 900;
  font-size: 18px;
  line-height: 135.5%;
  /* or 24px */

  text-align: center;
  text-decoration-line: underline;

  /* #316AE2 */

  color: #316ae2;

  cursor: pointer;
`;

export const FormRadio = styled.input`
  position: absolute;
  width: 24px;
  height: 24px;

  left: 200px;
  top: 630px;

  background: #ffffff;
  border: 1px solid #000000;
  box-sizing: border-box;
  border-radius: 50%;

  cursor: pointer;
`;

export const RadioText = styled.span`
  position: absolute;
  width: 50px;
  height: 24px;
  left: 225px;
  top: 633px;

  font-family: Pretendard;
  font-style: normal;
  font-weight: 500;
  font-size: 18px;
  line-height: 135.5%;
  /* or 24px */

  text-align: center;

  /* #000000 */

  color: #000000;
`;

export const FormRadio2 = styled.input`
  position: absolute;
  width: 24px;
  height: 24px;
  left: 300px;
  top: 630px;
  background: #ffffff;
  border: 1px solid #000000;
  box-sizing: border-box;

  border-radius: 50%;

  cursor: pointer;
`;

export const RadioText2 = styled.span`
  position: absolute;
  width: 50px;
  height: 24px;
  left: 325px;
  top: 633px;

  font-family: Pretendard;
  font-style: normal;
  font-weight: 500;
  font-size: 18px;
  line-height: 135.5%;
  /* or 24px */

  text-align: center;

  /* #000000 */

  color: #000000;
`;

export const FormTypeInput = styled.input`
  position: absolute;
  width: 502px;
  height: 15px;
  left: 25px;
  top: 670px;
  margin-bottom: 20px;

  border: none;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  /* #F2F2F2 */

  background: #f2f2f2;
  border-radius: 10px;

  font-size: 25px;
  padding: 20px;
`;
