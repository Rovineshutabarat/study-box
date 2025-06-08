import React from "react";
import { Cigarette } from "lucide-react";
import Link from "next/link";
import { Button } from "@/components/ui/button";

const MainNavbar = () => {
  const links = [
    { title: "Home", href: "/" },
    { title: "Courses", href: "/course/list" },
    { title: "Blogs", href: "/blogs" },
    { title: "About", href: "/about" },
    { title: "Contact", href: "/contact" },
  ];

  return (
    <header className="p-5 space-x-20 shadow-sm flex justify-around items-center">
      <div className="flex items-center gap-x-3">
        <Cigarette />
        <h1 className="text-[20px] font-semibold">Study Box</h1>
      </div>
      <ul className="flex items-center gap-x-7">
        {links.map((link) => {
          return <Link href={link.href}>{link.title}</Link>;
        })}
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
