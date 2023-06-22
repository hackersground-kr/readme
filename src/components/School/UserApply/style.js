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

export const Users = styled.div`
  position: absolute;
  top: 100px;
  left: 280px;
  width: 800px;
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

export const AllowButton = styled.img`
  position: relative;
  right: -60px;
  top: 45px;
`;

export const DenyButton = styled.img`
  position: relative;
  right: -130px;
  top: 45px;
`;
