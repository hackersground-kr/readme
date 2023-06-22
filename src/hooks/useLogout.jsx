import { useNavigate } from "react-router-dom";

export const useLogout = () => {
  const navigate = useNavigate();
  const onLogout = () => {
    localStorage.removeItem("accessToken");

    let date = new Date();
    date.setDate(date.getDate() - 1);

    let willCookie = "";
    willCookie += "refreshToken=Value;";
    willCookie += "Expires=" + date.toUTCString();
    document.cookie = willCookie;

    navigate("/login");
  };
  return { onLogout };
};
