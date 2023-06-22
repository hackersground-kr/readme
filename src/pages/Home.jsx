import React from "react";
import { EditInformation } from "../components/School/EditInformation";
import { EditIntroduce } from "../components/School/EditIntroduce";
import { SchoolSideBar } from "../components/School/SchoolSideBar";

export const Home = () => {
  return (
    <div>
      <SchoolSideBar />
      <EditInformation />
      <EditIntroduce />
    </div>
  );
};
