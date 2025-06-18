"use client";

import React from "react";
import { BookOpen } from "lucide-react";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import { useTheme } from "@/hooks/use-theme";

type NavigationMenu = {
  title: string;
  href: string;
};

const MainNavbar = () => { 
  const navigationMenu: NavigationMenu[] = [
    { title: "Home", href: "/" },
    { title: "Courses", href: "/courses" },
    { title: "Blogs", href: "/blogs" },
    { title: "About", href: "/about" },
    { title: "Contact", href: "/contact" },
  ];
  const { changeTheme } = useTheme();
  return (
    <header className="p-5 space-x-20 shadow-sm flex justify-around items-center">
      <div className="flex items-center gap-x-3">
        <BookOpen onClick={changeTheme} />
        <h1 className="text-2xl font-semibold">Study Box</h1>
      </div>
      <ul className="flex items-center gap-x-7">
        {navigationMenu.map((menu: NavigationMenu) => {
          return (
            <Link key={menu.title} href={menu.href}>
              {menu.title}
            </Link>
          );
        })}
      </ul>
      <div className="flex items-center gap-x-3">
        <Link href={"/auth/login"}>
          <Button variant="ghost" className="cursor-pointer">
            Sign In
          </Button>
        </Link>
        <Link href={"/auth/register"}>
          <Button className="cursor-pointer">Sign Up</Button>
        </Link>
      </div>
    </header>
  );
};

export default MainNavbar;
