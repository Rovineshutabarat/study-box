"use client";
import React from "react";
import { useTheme } from "@/hooks/use-theme";
import { Toaster } from "@/components/ui/sonner";

type AppLayoutProps = {
  children: React.ReactNode;
};

const AppLayout = ({ children }: AppLayoutProps) => {
  const { theme } = useTheme();
  return (
    <body className={theme}>
      <main>{children}</main>
      <Toaster
        visibleToasts={4}
        expand={true}
        theme={theme}
        richColors={true}
      />
    </body>
  );
};

export default AppLayout;
