import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Bookmark, Clock, Star, User } from "lucide-react";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Badge } from "@/components/ui/badge";
import { ScrollArea } from "@/components/ui/scroll-area";
import { Scrollbar } from "@radix-ui/react-scroll-area";
import { Button } from "@/components/ui/button";
import { cn } from "@/lib/utils";

const TopCourses = () => {
  const popularCourses = [
    {
      title: "UI/UX Design Fundamentals",
      image: "https://edma-theme.vercel.app/images/courses/course-8.png",
      rating: 4.6,
      reviews: "980",
      level: "Beginner",
      duration: "50 hours",
      modules: "120",
      price: "Rp.120.000",
      enrolled: "15,000",
      instructor: {
        name: "Jessica Taylor",
        avatar: "https://edma-theme.vercel.app/images/courses/course-8.png",
      },
    },
    {
      title: "Advanced Figma Techniques",
      image: "https://edma-theme.vercel.app/images/courses/course-8.png",
      rating: 4.7,
      reviews: "850",
      level: "Intermediate",
      duration: "45 hours",
      modules: "95",
      price: "Rp.150.000",
      enrolled: "12,000",
      instructor: {
        name: "Daniel White",
        avatar: "https://edma-theme.vercel.app/images/courses/course-8.png",
      },
    },
    {
      title: "User Research & Testing Masterclass",
      image: "https://edma-theme.vercel.app/images/courses/course-8.png",
      rating: 4.8,
      reviews: "1.3K",
      level: "Advanced",
      duration: "60 hours",
      modules: "150",
      price: "Rp.180.000",
      enrolled: "18,000",
      instructor: {
        name: "Olivia Green",
        avatar: "https://edma-theme.vercel.app/images/courses/course-8.png",
      },
    },
    {
      title: "Mobile App UI Design for Beginners",
      image: "https://edma-theme.vercel.app/images/courses/course-8.png",
      rating: 4.5,
      reviews: "1.1K",
      level: "Beginner",
      duration: "40 hours",
      modules: "85",
      price: "Rp.120.000",
      enrolled: "22,000",
      instructor: {
        name: "Chris Johnson",
        avatar: "https://edma-theme.vercel.app/images/courses/course-8.png",
      },
    },
  ];

  const categories = [
    { name: "Design" },
    { name: "Web Development" },
    { name: "Data Science" },
    { name: "Marketing" },
    { name: "Business" },
    { name: "Lifestyle" },
  ];

  return (
    <section className="py-20">
      <div className="container px-4 mx-auto">
        <div className="text-center mb-8">
          <h2 className="mb-2 text-2xl font-bold md:text-3xl">
            Our Most <span className="text-blue-500">Popular Courses</span>
          </h2>
          <p className="text-muted-foreground">
            Looking for a quick go through? here are the most popular that
            people take.
          </p>
        </div>

        <div className="mb-12">
          <div className="flex flex-wrap justify-center mb-8 bg-transparent w-full h-auto p-0 space-x-4 md:space-x-8">
            {categories.map((category) => (
              <Button
                key={category.name}
                variant="underline"
                className={cn(
                  category.name === "Design"
                    ? "after:w-full text-foreground"
                    : "after:w-0 hover:after:w-full",
                )}
              >
                {category.name}
              </Button>
            ))}
          </div>

          <div className="mt-0">
            <ScrollArea className="w-full rounded-md">
              <div className="flex w-max space-x-6 p-4">
                {popularCourses.map((course) => (
                  <Card
                    key={course.rating}
                    className="transition-all w-[22rem] duration-300 border-transparent dark:border-primary/10 cursor-pointer group shadow-sm hover:shadow-md rounded-lg"
                  >
                    <div className="relative h-48 overflow-hidden">
                      <img
                        src={course.image}
                        alt={course.title}
                        className="object-cover w-full h-full transition-transform duration-300 group-hover:scale-105"
                      />
                      <div className="absolute top-3 right-3">
                        <Badge
                          variant="outline"
                          className="bg-background backdrop-blur-sm"
                        >
                          {course.level}
                        </Badge>
                      </div>
                    </div>
                    <CardContent className="p-5">
                      <div className="flex justify-between items-center mb-3">
                        <div className="flex items-center gap-x-1 text-sm text-muted-foreground">
                          <Clock className="h-4 w-4" />
                          <span>{course.duration}</span>
                        </div>
                        <div className="flex items-center gap-x-1 text-sm text-muted-foreground">
                          <Bookmark className="h-4 w-4" />
                          <span>{course.modules} Module</span>
                        </div>
                        <div className="flex items-center gap-x-1 text-sm text-muted-foreground">
                          <User className="h-4 w-4" />
                          <span>15.000 Students</span>
                        </div>
                      </div>

                      <h3 className="text-lg font-semibold mb-2 line-clamp-1">
                        {course.title}
                      </h3>
                      <p className="text-sm text-muted-foreground mb-4 line-clamp-2">
                        Lorem ipsum dolor sit amet, consectetur adipisicing
                        elit. Aut consequatur ex nisi odit quidem ullam. Elit.
                        Aut consequatur ex nisi odit quidem ullam.
                      </p>

                      <div className="flex items-center mb-3">
                        <div className="flex items-center">
                          {[1, 2, 3, 4, 5].map((star) => (
                            <Star
                              key={star}
                              className={`w-4 h-4 ${
                                star <= Math.floor(course.rating)
                                  ? "text-yellow-500 fill-yellow-500"
                                  : star - course.rating <= 0.5
                                    ? "text-yellow-500 fill-yellow-500 opacity-50"
                                    : "text-gray-300"
                              }`}
                            />
                          ))}
                        </div>
                        <span className="ml-2 text-sm font-medium">
                          {course.rating}
                        </span>
                        <span className="ml-1 text-xs text-muted-foreground">
                          ({course.reviews} Reviews)
                        </span>
                      </div>

                      <div className="flex justify-between items-center pt-3 border-t">
                        <div className="flex items-center">
                          <Avatar className="w-8 h-8 mr-2 border">
                            <AvatarImage
                              src={course.instructor.avatar}
                              alt={course.instructor.name}
                            />
                            <AvatarFallback>
                              {course.instructor.name.charAt(0)}
                            </AvatarFallback>
                          </Avatar>
                          <span className="text-sm font-medium">
                            {course.instructor.name}
                          </span>
                        </div>
                        <div className="font-bold text-lg">{course.price}</div>
                      </div>
                    </CardContent>
                  </Card>
                ))}
              </div>
              <Scrollbar orientation="horizontal" />
            </ScrollArea>
          </div>
        </div>
      </div>
    </section>
  );
};

export default TopCourses;
