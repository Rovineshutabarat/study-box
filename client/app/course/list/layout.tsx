import React from "react";
import CourseFilter from "@/components/features/course/filter";
import CourseNavbar from "@/components/features/course/navbar";

type CourseListLayoutProps = {
  children: React.ReactNode;
};
const CourseListLayout = ({ children }: CourseListLayoutProps) => {
  return (
    <section className="flex flex-col">
      <CourseNavbar />
      <div className="flex flex-1 mt-3 mx-10 gap-x-10">
        <CourseFilter />
        {children}
      </div>
    </section>
  );
};

export default CourseListLayout;
