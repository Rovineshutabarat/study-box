import React from "react";
import { Button } from "@/components/ui/button";
import { Star, X } from "lucide-react";
import {
  Accordion,
  AccordionContent,
  AccordionItem,
  AccordionTrigger,
} from "@/components/ui/accordion";
import { Checkbox } from "@/components/ui/checkbox";
import { Slider } from "@/components/ui/slider";

const CourseFilter = () => {
  const courseLevel = [
    { name: "Beginner", value: "BEGINNER" },
    { name: "Intermediate", value: "INTERMEDIATE" },
    { name: "Advanced", value: "ADVANCED" },
  ];

  const courseDuration = [
    "< 20 hours",
    "20-40 hours",
    "40-60 hours",
    "> 60 hours",
  ];

  const courseRating = [4.5, 4.0, 3.5, 3.0];
  return (
    <div className="transition-transform duration-300 h-full md:h-auto w-72">
      <div className="p-4 md:p-0 sticky top-20 left-0">
        <div className="flex items-center justify-between md:justify-start mb-2">
          <h2 className="text-lg font-bold">Course Filters</h2>
          <Button variant="ghost" size="sm" className="md:hidden">
            <X className="h-4 w-4" />
          </Button>
        </div>

        <div className="space-y-5 max-h-[calc(100vh-120px)] overflow-y-auto pr-7 pb-4">
          <Accordion type="multiple" defaultValue={["level", "duration"]}>
            <AccordionItem value="category">
              <AccordionTrigger className="text-sm font-medium py-2">
                Categories
              </AccordionTrigger>
              {/*<AccordionContent>*/}
              {/*    <div className="space-y-2">*/}
              {/*        {categories.map((category, index) => (*/}
              {/*            <div key={index} className="flex items-center gap-2">*/}
              {/*                <Checkbox id={`category-${index}`}/>*/}
              {/*                <label htmlFor={`category-${index}`} className="text-sm cursor-pointer">*/}
              {/*                    {category.name}*/}
              {/*                </label>*/}
              {/*            </div>*/}
              {/*        ))}*/}
              {/*    </div>*/}
              {/*</AccordionContent>*/}
            </AccordionItem>

            <AccordionItem value="level">
              <AccordionTrigger className="text-sm font-medium py-2">
                Level
              </AccordionTrigger>
              <AccordionContent>
                <div className="space-y-2">
                  {courseLevel.map((level, index) => (
                    <div key={index} className="flex items-center gap-2">
                      <Checkbox id={`level-${index}`} value={level.value} />
                      <label
                        htmlFor={`level-${index}`}
                        className="text-sm cursor-pointer"
                      >
                        {level.name}
                      </label>
                    </div>
                  ))}
                </div>
              </AccordionContent>
            </AccordionItem>

            <AccordionItem value="price">
              <AccordionTrigger className="text-sm font-medium py-2">
                Price Range
              </AccordionTrigger>
              <AccordionContent>
                <div className="space-y-4">
                  <Slider
                    defaultValue={[0, 200000]}
                    max={300000}
                    step={10000}
                  />
                  <div className="flex justify-between">
                    <span className="text-xs">Rp 0</span>
                    <span className="text-xs">Rp 300.000</span>
                  </div>
                </div>
              </AccordionContent>
            </AccordionItem>

            <AccordionItem value="duration">
              <AccordionTrigger className="text-sm font-medium py-2">
                Duration
              </AccordionTrigger>
              <AccordionContent>
                <div className="space-y-2">
                  {courseDuration.map((duration, index) => (
                    <div key={index} className="flex items-center gap-2">
                      <Checkbox id={`duration-${index}`} />
                      <label
                        htmlFor={`duration-${index}`}
                        className="text-sm cursor-pointer"
                      >
                        {duration}
                      </label>
                    </div>
                  ))}
                </div>
              </AccordionContent>
            </AccordionItem>

            <AccordionItem value="rating">
              <AccordionTrigger className="text-sm font-medium py-2">
                Rating
              </AccordionTrigger>
              <AccordionContent>
                <div className="space-y-2">
                  {courseRating.map((rating, index) => (
                    <div key={index} className="flex items-center gap-2">
                      <Checkbox id={`rating-${index}`} />
                      <label
                        htmlFor={`rating-${index}`}
                        className="text-sm cursor-pointer flex items-center"
                      >
                        <div className="flex mr-1">
                          {[1, 2, 3, 4, 5].map((star) => (
                            <>
                              <Star
                                key={star}
                                className={`w-3 h-3 ${
                                  star <= Math.floor(rating)
                                    ? "text-yellow-500 fill-yellow-500"
                                    : star - rating <= 0.5
                                      ? "text-yellow-500 fill-yellow-500 opacity-50"
                                      : "text-gray-300"
                                }`}
                              ></Star>
                            </>
                          ))}
                        </div>
                        <span>{rating} star up</span>
                      </label>
                    </div>
                  ))}
                </div>
              </AccordionContent>
            </AccordionItem>
          </Accordion>

          <div className="mt-4 space-y-3">
            <Button className="w-full">Apply Filters</Button>
            <Button variant="outline" className="w-full">
              Reset
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CourseFilter;
