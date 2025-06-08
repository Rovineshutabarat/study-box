import React from "react";
import { BookOpen } from "lucide-react";
import Link from "next/link";
import { Button } from "@/components/ui/button";

const MainNavbar = () => {
  return (
    <header className="p-5 space-x-20 shadow-sm flex justify-around items-center">
      <div className="flex items-center gap-x-3">
        <BookOpen />
        <h1 className="text-[20px]">Study Box</h1>
      </div>
      <ul className="flex items-center gap-x-7">
        <Link href="/client/public">Home</Link>
        <Link href="/courses">Courses</Link>
        <li>Blogs</li>
        <li>About</li>
        <li>Contact</li>
      </ul>
      <div className="flex items-center gap-x-3">
        <Link href={"/auth/login"}>Sign In</Link>
        <Link href={"/auth/register"}>
          <Button>Sign Up</Button>
        </Link>
      </div>
    </header>
  );
};

export default MainNavbar;
