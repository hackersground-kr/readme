import React from "react";

import * as S from "./style";
import { useNavigate } from "react-router-dom";
import { useLogout } from "../../../hooks/useLogout";

export const SchoolSideBar = () => {
  const navigate = useNavigate();
  const { onLogout } = useLogout();
  return (
    <S.SidebarContainer>
      <S.Logo onClick={() => navigate("/")}>ReadMe</S.Logo>
      <S.MenuItems>
        <S.MenuItem onClick={() => navigate("/list")}>기업목록</S.MenuItem>
        <S.MenuItem onClick={() => navigate("/recommend")}>학생추천</S.MenuItem>
      </S.MenuItems>
      <S.BottomMenu onClick={onLogout}>로그아웃</S.BottomMenu>
    </S.SidebarContainer>
  );
};
