"use client";

import React from "react"; 
import { Button } from "@/components/ui/button";
import { useTheme } from "@/hooks/use-theme";
import { toast } from "sonner";

const Page = () => {
  const { changeTheme } = useTheme();
  return (
    <div className="flex items-center space-x-2 justify-center">
      <Button onClick={changeTheme}>Kontl</Button>
      <Button onClick={() => toast.success("aksdjnkjadsn")}>Kontl</Button>
    </div>
  );
};

export default Page;
