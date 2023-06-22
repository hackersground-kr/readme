import styled from "styled-components";

export const Box = styled.div`
  background-color: transparent;
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
`;

export const GroupWrapper = styled.div`
  border: 0px none;
  height: 411px;
  overflow-x: hidden;
  position: relative;
  width: 772px;
`;

export const Group = styled.div`
  height: 411px;
  left: 0;
  position: fixed;
  top: 0;
  width: 780px;
`;

export const Overlap = styled.div`
  background-color: #ffffff;
  border: 1px solid;
  border-color: #17bdff;
  border-radius: 35px;
  box-shadow: 3px 3px 10px 2px #00000040;
  height: 374px;
  left: 300px;
  position: absolute;
  top: 150px;
  width: 774px;
`;

export const TextWrapper = styled.div`
  color: #000000;
  font-family: "Pretendard-Medium", Helvetica;
  font-size: 24px;
  font-weight: 500;
  left: 138px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 54px;
  white-space: nowrap;
  width: 312px;
`;

export const Element = styled.img`
  height: 94px;
  left: 17px;
  object-fit: cover;
  position: absolute;
  top: 22px;
  width: 110px;
`;

export const Line = styled.hr`
  height: 1px;
  left: 13px;
  object-fit: cover;
  position: absolute;
  width: 746px;
  border-top: 1px solid #bbb;
  border-bottom: none;
  border-left: none;
  border-right: none;
  &.line {
    top: 125px;
  }

  &.line-2 {
    top: 285px;
  }
`;

export const Line2 = styled.hr`
  height: 1px;
  left: 13px;
  object-fit: cover;
  position: absolute;
  border-top: 1px solid #bbb;
  border-bottom: none;
  border-left: none;
  border-right: none;
  top: 205px;
  width: 746px;
`;

export const Div = styled.div`
  color: #000000;
  font-family: "Pretendard-Regular", Helvetica;
  font-size: 24px;
  font-weight: 400;
  left: 97px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 154px;
`;

export const Group2 = styled.img`
  height: 32px;
  left: 32px;
  position: absolute;
  top: 153px;
  width: 34px;
`;

export const P = styled.p`
  color: #000000;
  font-family: "Pretendard-Regular", Helvetica;
  font-size: 24px;
  font-weight: 400;
  left: 97px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 210px;
`;

export const OverlapGroupWrapper = styled.div`
  height: 36px;
  left: 86px;
  position: absolute;
  top: 311px;
  width: 146px;
`;

export const OverlapGroup = styled.button`
  background-color: #17bdff;
  border-radius: 30px;
  height: 36px;
  position: relative;
  width: 144px;
  border: none;
  cursor: pointer;
`;

export const TextWrapper2 = styled.div`
  color: #ffffff;
  font-family: "Pretendard-Regular", Helvetica;
  font-size: 20px;
  font-weight: 400;
  height: 24px;
  left: 17px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  text-align: center;
  top: 6px;
  white-space: nowrap;
`;

export const OverlapWrapper = styled.div`
  height: 40px;
  left: 655px;
  position: absolute;
  top: 229px;
  width: 92px;
`;

export const DivWrapper = styled.button`
  background-color: #17bdff;
  border-radius: 20px;
  height: 40px;
  position: relative;
  width: 90px;
  border: none;
  cursor: pointer;
`;

export const TextWrapper3 = styled.div`
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

export const IconLocation = styled.img`
  height: 30px;
  left: 34px;
  position: absolute;
  top: 233px;
  width: 30px;
`;

export const IconImage = styled.img`
  height: 32px;
  left: 23px;
  position: absolute;
  top: 309px;
  width: 36px;
`;

export const H1 = styled.h1`
  color: #000000;
  font-family: "Pretendard-SemiBold", Helvetica;
  font-size: 24px;
  font-weight: 600;
  height: 29px;
  margin: 0;
  left: 49px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  text-align: center;
  top: -40px;
`;

export const Image = styled.img`
  height: 30px;
  left: 16px;
  object-fit: cover;
  position: absolute;
  top: -40px;
  width: 26px;
`;