import React from "react";
import { Clock, GraduationCap, TrendingUp } from "lucide-react";
import { Button } from "@/components/ui/button";

const MainAdvantages = () => {
  const advantages = [
    {
      title: "Flexible Learning Schedules",
      icon: <Clock className="w-4 h-4 text-green-600" />,
    },
    {
      title: "Monitor and improve learning outcomes",
      icon: <TrendingUp className="w-4 h-4 text-yellow-600" />,
    },
    {
      title: "Learn from industry professionals",
      icon: <GraduationCap className="w-4 h-4 text-blue-600" />,
    },
  ];
  return (
    <section className="relative pt-28 pb-16 overflow-hidden lg:pt-16 lg:pb-16">
      <div className="absolute inset-0 -z-10">
        <div className="absolute bottom-0 left-0 w-[600px] h-[600px] bg-primary/5 rounded-full -translate-y-1/2 translate-x-1/3 blur-3xl"></div>
        <div className="absolute top-0 right-0 w-[600px] h-[600px] bg-teal-400/10 rounded-full translate-y-1/2 -translate-x-1/3 blur-3xl"></div>
      </div>
      <section className="py-20 ">
        <div className="container px-4 mx-auto">
          <div className="grid grid-cols-1 gap-12 lg:grid-cols-2">
            <div className="max-w-xl">
              <h2 className="mb-6 text-3xl font-bold md:text-4xl">
                Why Study Box is the{" "}
                <span className="text-blue-500">#1921737 Choice</span> for
                Students?
              </h2>
              <p className="mb-8 text-muted-foreground">
                Our instructors are professional in their skills, they have
                years of experience and good at explaining. We at Wahyedu,
                always care our instructors and students to gain more knowledge
                by giving them benefits, like:
              </p>

              <div className="space-y-4">
                {advantages.map((advantage, index) => {
                  return (
                    <div className="flex items-start gap-4">
                      <div className="flex items-center justify-center w-8 h-8 mt-1 rounded-full bg-green-100">
                        {advantage.icon}
                      </div>
                      <div>
                        <p className="font-medium">{advantage.title}</p>
                      </div>
                    </div>
                  );
                })}
              </div>

              <Button className="mt-8 bg-blue-500 hover:bg-blue-600 text-white rounded-full px-8">
                Start Learning Today
              </Button>
            </div>

            <div className="grid grid-cols-2 gap-4">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZjrHJ7etMn2x06FgG4AFV5bE4owz4u7cpCw&s"
                alt="Student studying"
                className="rounded-2xl w-full h-auto object-cover"
              />
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5RSUtGdQTfbl53Pwtl3iqLqMpYKBM6WONQQ&s"
                alt="Student with headphones"
                className="rounded-2xl w-full h-auto object-cover mt-8"
              />
              <img
                src="https://media.istockphoto.com/id/1354077790/photo/man-working-at-home.jpg?s=612x612&w=0&k=20&c=ePzpG0JgiHd4R85JyoyxIndl4vYQP6avw9nNJ6Zgg8w="
                alt="Student writing"
                className="rounded-2xl w-full h-auto object-cover"
              />
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI1jZbSfgaVNtyY5vqYEXMiu_AVqdLg6Fk5w&s"
                alt="Student with tablet"
                className="rounded-2xl w-full h-auto object-cover mt-8"
              />
            </div>
          </div>
        </div>
      </section>
    </section>
  );
};

export default MainAdvantages;
