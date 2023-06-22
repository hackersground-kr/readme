import styled from "styled-components";

export const Title = styled.div`
  color: #000;
  position: absolute;
  left: 280px;
  font-size: 40px;
  font-family: Pretendard;
  font-weight: 700;
`;

export const Line = styled.hr`
  position: absolute;
  top: 60px;
  left: 280px;
  width: 800px;
  border-top: 1px solid #bbb;
  border-bottom: none;
  border-left: none;
  border-right: none;
`;

export const Line2 = styled.hr`
  position: absolute;
  top: 200px;
  left: 280px;
  width: 620px;
  border-top: 1px solid #bbb;
  border-bottom: none;
  border-left: none;
  border-right: none;
`;

export const Line3 = styled.hr`
  position: relative;
  /* top: 200px;
  left: 900px; */
  /* margin-top: 40px; */
  width: 620px;
  border-top: 1px solid #bbb;
  border-bottom: none;
  border-left: none;
  border-right: none;
`;

export const Recommending = styled.div`
  position: absolute;
  top: 150px;
  left: 280px;

  color: #000;
  font-size: 48px;
  font-family: Pretendard;
  font-weight: 500;
`;

export const RecommendingUsers = styled.div`
  position: absolute;
  top: 200px;
  left: 280px;
  width: 620px;
`;

export const User = styled.div`
  text-align: start;
  height: 125px;

  border-radius: 20px;
  border: 1px solid #17bdff;
  background: #fff;
  box-shadow: 3px 3px 20px 3px rgba(0, 0, 0, 0.25);
  margin-top: 30px;
`;

export const UserName = styled.span`
  position: relative;
  top: 30px;
  left: 30px;

  color: #000;
  text-align: center;
  font-size: 32px;
  font-family: Pretendard;
  font-weight: 700;
`;

export const UserSchool = styled.span`
  position: relative;
  top: 20px;
  left: 30px;

  color: #000;
  text-align: center;
  font-size: 20px;
  font-family: Pretendard;
  font-weight: 100;
`;

export const UserEmail = styled.span`
  position: relative;
  top: 60px;
  left: -310px;

  color: #000;
  font-size: 20px;
  font-family: Pretendard;
  font-weight: 100;
`;

export const WaitingUsers = styled.div`
  position: relative;
  top: 20px;
  margin-top: 30px;
`;

export const Waiting = styled.div`
  text-align: start;

  margin-top: 30px;

  color: #000;
  font-size: 48px;
  font-family: Pretendard;
  font-weight: 500;
`;
