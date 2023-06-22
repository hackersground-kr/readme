import React from "react";

import * as S from "./style";

export const SchoolSideBar = () => {
  return (
    <S.SidebarContainer>
      <S.Logo>ReadMe</S.Logo>
      <S.MenuItems>
        <S.MenuItem>학생승인</S.MenuItem>
        <S.MenuItem>학생추천</S.MenuItem>
        <S.MenuItem>기업목록</S.MenuItem>
      </S.MenuItems>
      <S.BottomMenu>로그아웃</S.BottomMenu>
    </S.SidebarContainer>
  );
};
