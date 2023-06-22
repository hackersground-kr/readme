import React from "react";
import styled from "styled-components";

// 스타일 컴포넌트를 사용하여 스타일을 정의합니다.
const SidebarContainer = styled.div`
  position: fixed;
  height: 100%;
  width: 200px;
  background-color: #ffffff;
  padding: 20px;
  box-shadow: 3px 3px 10px 2px #00000040;
`;

const Logo = styled.div`
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
`;

const MenuItems = styled.div`
  position: absolute;
  top: 400px;
  left: 80px;
`;

const MenuItem = styled.div`
  font-size: 24px;
  margin-bottom: 20px;
  cursor: pointer;
`;

const BottomMenu = styled.div`
  position: absolute;
  bottom: 0;
  left: 0;
  margin-left: 10px;
  width: 90%;
  height: 70px;
  background-color: #ff5f5f;
  margin-bottom: 50px;
  border-radius: 20px;

  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 24px;
  color: white;
  cursor: pointer;
`;

export const SchoolSideBar = () => {
  return (
    <SidebarContainer>
      <Logo>ReadMe</Logo>
      <MenuItems>
        <MenuItem>학생승인</MenuItem>
        <MenuItem>학생추천</MenuItem>
        <MenuItem>기업목록</MenuItem>
      </MenuItems>
      <BottomMenu>로그아웃</BottomMenu>
    </SidebarContainer>
  );
};
