"use client";

import React from "react";

type ThemeProviderProps = {
  children: React.ReactNode;
};

type ThemeProviderContextState = {
  theme: "light" | "dark";
  changeTheme: () => void;
};

const ThemeProviderContext = React.createContext<
  ThemeProviderContextState | undefined
>(undefined);

const ThemeProvider = ({ children }: ThemeProviderProps) => {
  const [theme, setTheme] = React.useState<"light" | "dark">("light");

  function changeTheme(): void {
    const currentTheme: string | null = localStorage.getItem("theme");
    const updatedTheme: "light" | "dark" =
      currentTheme === "light" ? "dark" : "light";
    setTheme(updatedTheme);
    localStorage.setItem("theme", updatedTheme);
  }

  return (
    <ThemeProviderContext.Provider value={{ theme, changeTheme }}>
      {children}
    </ThemeProviderContext.Provider>
  );
};

export { ThemeProvider, ThemeProviderContext };
