import React from "react";
import { Bell, Cigarette, ShoppingCart } from "lucide-react";
import SearchInput from "@/components/shared/search-input";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

const CourseNavbar = () => {
  return (
    <div className="flex justify-between px-10 p-4 shadow-sm sticky top-0 z-50 bg-background items-center">
      <div className="flex items-center gap-x-3">
        <Cigarette />
        <h1 className="text-[20px] font-semibold">Study Box</h1>
      </div>
      <SearchInput title="Search any course..." inputSize="large" />
      <div className="flex items-center gap-x-5">
        <Bell />
        <ShoppingCart />
        <Avatar>
          <AvatarImage src="https://github.com/shadcn.png" />
          <AvatarFallback>CN</AvatarFallback>
        </Avatar>
      </div>
    </div>
  );
};

export default CourseNavbar;
