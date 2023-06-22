import styled from "styled-components";

export const Box = styled.div`
  background-color: transparent;
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
`;

export const GroupWrapper = styled.div`
  /* border: 0px none;
  height: 349px;
  overflow-x: hidden;
  position: relative;
  width: 772px; */
`;

export const Group = styled.div`
  height: 349px;
  left: 300px;
  position: fixed;
  top: 580px;
  width: 776px;
`;

export const Overlap = styled.div`
  height: 241px;
  left: 0;
  position: absolute;
  top: 42px;
  width: 772px;
`;

export const RectangleWrapper = styled.div`
  height: 241px;
  left: 0;
  position: absolute;
  top: 0;
  width: 772px;
`;

export const Rectangle = styled.div`
  background-color: #ffffff;
  border: 1px solid;
  border-color: #17bdff;
  border-radius: 35px;
  box-shadow: 3px 3px 10px 2px #00000040;
  height: 243px;
  left: -1px;
  position: relative;
  top: -1px;
  width: 774px;
`;

export const Div = styled.div`
  background-color: #f4f4f4;
  border-radius: 35px;
  height: 200px;
  left: 26px;
  position: absolute;
  top: 18px;
  width: 720px;
`;

export const TextWrapper = styled.p`
  color: #000000;
  font-family: "Pretendard-Regular", Helvetica;
  font-size: 24px;
  font-weight: 400;
  left: 71px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 34px;
  margin: 0;
`;

export const H1 = styled.h1`
  color: #000000;
  font-family: "Pretendard-SemiBold", Helvetica;
  font-size: 24px;
  font-weight: 600;
  height: 29px;
  left: 49px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  text-align: center;
  top: 1px;
  margin: 0;
`;

export const Image = styled.img`
  height: 30px;
  left: 13px;
  object-fit: cover;
  position: absolute;
  top: 0;
  width: 30px;
`;

export const OverlapGroupWrapper = styled.div`
  height: 40px;
  left: 655px;
  position: absolute;
  top: 309px;
  width: 92px;
`;

export const OverlapGroup = styled.button`
  background-color: #17bdff;
  border-radius: 20px;
  height: 40px;
  position: relative;
  width: 90px;

  border: none;
  cursor: pointer;
`;

export const TextWrapper2 = styled.div`
  color: #ffffff;
  font-family: "Pretendard-Regular", Helvetica;
  font-size: 24px;
  font-weight: 400;
  height: 29px;
  left: 24px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  text-align: center;
  top: 5px;
`;
