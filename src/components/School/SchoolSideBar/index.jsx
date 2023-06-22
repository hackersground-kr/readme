import React from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";

export const SchoolSideBar = () => {
  const navigate = useNavigate();
  return (
    <S.SidebarContainer>
      <S.Logo onClick={() => navigate("/")}>ReadMe</S.Logo>
      <S.MenuItems>
        <S.MenuItem onClick={() => navigate("/accept")}>기업목록</S.MenuItem>
        <S.MenuItem onClick={() => navigate("/recommend")}>학생추천</S.MenuItem>
      </S.MenuItems>
      <S.BottomMenu>로그아웃</S.BottomMenu>
    </S.SidebarContainer>
  );
};
