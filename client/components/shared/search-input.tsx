import React from "react";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { SearchIcon } from "lucide-react";
import { cn } from "@/lib/utils";

interface SearchInputProps extends React.InputHTMLAttributes<HTMLInputElement> {
  title: string;
  inputSize: "small" | "medium" | "large";
}

const sizeClasses = {
  small: "w-[20rem]",
  medium: "w-[25rem]",
  large: "w-[30rem]",
};

const SearchInput = ({ title, inputSize, ...props }: SearchInputProps) => {
  return (
    <div
      className={cn(
        "flex items-center space-x-2 max-w-full",
        sizeClasses[inputSize],
      )}
    >
      <Input type="search" placeholder={title} className="h-9" {...props} />
      <Button variant="outline" size="sm" className="h-9 px-3">
        <SearchIcon className="h-4 w-4" />
        <span className="sr-only">Search</span>
      </Button>
    </div>
  );
};

export default SearchInput;
