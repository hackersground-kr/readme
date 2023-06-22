import styled from "styled-components";

export const SidebarContainer = styled.div`
  position: fixed;
  height: 100%;
  width: 200px;
  background-color: #ffffff;
  padding: 20px;
  box-shadow: 3px 3px 10px 2px #00000040;
`;

export const Logo = styled.div`
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
  cursor: pointer;
`;

export const MenuItems = styled.div`
  position: absolute;
  top: 400px;
  left: 80px;
`;

export const MenuItem = styled.div`
  font-size: 24px;
  margin-bottom: 20px;
  cursor: pointer;
`;

export const BottomMenu = styled.div`
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
