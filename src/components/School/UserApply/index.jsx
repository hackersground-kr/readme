import React from "react";

import * as S from "./style";

import Allow from "../../../assets/svg/check.svg";
import Deny from "../../../assets/svg/error.svg";

const UserApply = () => {
  return (
    <div>
      <S.Title>현재 승인 대기중인 학생</S.Title>
      <S.Line />
      <S.Users>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
          <S.AllowButton src={Allow} />
          <S.DenyButton src={Deny} />
        </S.User>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
          <S.AllowButton src={Allow} />
          <S.DenyButton src={Deny} />
        </S.User>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
          <S.AllowButton src={Allow} />
          <S.DenyButton src={Deny} />
        </S.User>
      </S.Users>
    </div>
  );
};

export default UserApply;
