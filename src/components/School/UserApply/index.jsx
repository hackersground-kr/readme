import React from "react";

import * as S from "./style";

const UserApply = () => {
  return (
    <div>
      <S.Title>기업 목록</S.Title>
      <S.Line />
      <S.Users>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
        </S.User>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
        </S.User>
        <S.User>
          <S.UserName>김명봉</S.UserName>
          <S.UserSchool>대구소프트웨어마이스터고등학교</S.UserSchool>
          <S.UserEmail>kmjoplopl@gmail.com</S.UserEmail>
        </S.User>
      </S.Users>
    </div>
  );
};

export default UserApply;
